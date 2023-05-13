<template>
  <div class="q-pa-md">
    <q-table flat bordered :rows="rows"
             :filter="filter" :columns="columns" row-key="name" white color="amber">
      <template v-slot:top-left>
        <div class="row">
          <q-btn color="primary" :disable="loading" label="Add row" @click="addTenantDialogOpen = true" />
        </div>
      </template>
      <template v-slot:top-right>
        <q-input borderless dense debounce="300" v-model="filter" placeholder="Search">
          <template v-slot:append>
            <q-icon name="search" />
          </template>
        </q-input>
      </template>
      <template v-slot:body-cell-action="props">
        <q-td :props="props">
          <div class="text-right">
            <q-btn icon="edit" round color="secondary" class="q-mr-sm"/>
            <q-btn icon="delete" round color="red"/>
          </div>
        </q-td>
      </template>
    </q-table>
    <tenants-form v-model:opened="addTenantDialogOpen"/>
  </div>
</template>

<script>
import { ref } from 'vue'
import axios from "axios"
import TenantsForm from "components/TenantsForm.vue"
const columns = [
  {
    name: 'name',
    required: true,
    label: 'Name',
    align: 'left',
    field: row => row,
    format: val => `${val.firstName} ${val.lastName}`,
    sortable: true
  },
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
      addTenantDialogOpen: false
    }
  },
  async created () {
    const response = await axios.get('/api/tenant/findAll')
    this.rows = response.data
    console.log(this.rows)
  }
}
</script>
