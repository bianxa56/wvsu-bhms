<template>
  <div class="q-pa-md">
    <q-table flat bordered :rows="rows" title="Tenants"
             :filter="filter" :columns="columns" row-key="name" white color="amber">
      <template v-slot:top-right>
        <div>
          <div class="row" style="display: flex; align-items: center;">
            <q-input borderless dense debounce="300" v-model="filter" placeholder="Search">
              <template v-slot:append>
                <q-icon name="search" />
              </template>
            </q-input>
          </div>
          <div class="row" style="margin-top: 5px; margin-left: 90px;">
            <q-btn color="lime-10" :disable="loading" label="Add row"
                   @click="tenant = null; addTenantDialogOpen = true" />
          </div>
        </div>
      </template>


      <template v-slot:body-cell-action="props">
        <q-td :props="props">
          <div class="text-right">
            <q-btn icon="edit" round color="secondary" class="q-mr-sm" @click="editTenant(props.row)"/>
            <q-btn icon="delete" round color="red" @click="deleteTenant(props.row.id)"/>
          </div>
        </q-td>
      </template>
    </q-table>
    <tenants-form v-model:opened="addTenantDialogOpen" :data="tenant"/>
  </div>
</template>

<script>
import { ref } from 'vue'
import axios from "axios"
import TenantsForm from "components/TenantsForm.vue"
import {Events} from "src/events/events";
const columns = [
  { name: 'name', required: true, label: 'Name', align: 'left',
    field: row => row, format: val => `${val.firstName} ${val.lastName}`, sortable: true},
  { name: 'roomNumber', align: 'center', label: 'Room number', field: 'roomNumber', sortable: true },
  { name: 'address', align: 'center', label: 'Address', field: 'address' },
  { name: 'contactNumber', label: 'Contact number', field: 'contactNumber' },
  { name: 'action', align: 'center', label: 'Action', field: 'action' },

]

export default {
  components: {TenantsForm},
  setup () {
    return {
      filter: ref(''),
      columns

    }
  },
  data () {
    return {
      rows: [],
      addTenantDialogOpen: false,
      tenant: null
    }
  },
  methods: {
    async deleteTenant(id) {
      try {
        const response = await axios.post("/api/tenant/delete", null, { params : { id } })
        console.log(response.data)
        const index = this.rows.findIndex(row => row.id === id)
        console.log('index:', index)
        if (index !== -1) {
          this.rows.splice(index, 1)
        }
        this.notifySuccess('Tenant successfully deleted.')
      } catch (error) {
        console.log(error)
        this.notifyError(error)
      }
    },
    async editTenant(tenant) {
      console.log(tenant)
      this.tenant = tenant
      this.addTenantDialogOpen = true
    },
  },
  async created () {
    const response = await axios.get('/api/tenant/findAll')
    this.rows = response.data
    console.log(this.rows)
  }
}
</script>
