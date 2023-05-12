<template>
  <div class="q-pa-md">
    <q-table flat bordered title="Tenants" :rows="rows"
             :filter="filter" :columns="columns" row-key="name" white color="amber">
      <template v-slot:top-left>
        <q-btn color="primary" :disable="loading" label="Add row" @click="addRow" />
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
  </div>
</template>

<script>
import { ref } from 'vue'
const columns = [
  {
    name: 'name',
    required: true,
    label: 'Name',
    align: 'left',
    field: row => row.name,
    format: val => `${val}`,
    sortable: true
  },
  { name: 'roomNumber', align: 'center', label: 'Room number', field: 'roomNumber', sortable: true },
  { name: 'address', align: 'center', label: 'Address', field: 'address' },
  { name: 'contactNumber', label: 'Contact number', field: 'contactNumber' },
  { name: 'action', align: 'center', label: 'Action', field: 'action' },

]

const rows = [
  {
    roomNumber: 101,
    name: 'John Wick',
    address: '221B Baker Street, London',
    contactNumber: '995 796 322',
    action: ""
  },
  {
    roomNumber: 102,
    name: 'Leonardo DiCaprio',
    address: '123 Main Street, Anytown USA',
    contactNumber: '995 796 322',
    action: ""
  },
  {
    roomNumber: 103,
    name: 'Anne Hathaway',
    address: '742 Evergreen Terrace, Springfield',
    contactNumber: '995 796 322',
    action: ""
  },
  {
    roomNumber: 104,
    name: 'Anne Hathaway',
    address: '74 Privet Drive, Little Whinging, Surrey',
    contactNumber: '995 796 322',
    action: ""
  },
  {
    roomNumber: 105,
    name: 'Doja Cat',
    address: '221B Cemetery Lane, Misty Mountains',
    contactNumber: '995 796 322',
    action: ""
  },
  {
    roomNumber: 106,
    name: 'Kendrick Lamar',
    address: '221B Cemetery Lane, Misty Mountains',
    contactNumber: '995 796 322',
    action: ""
  },
  {
    roomNumber: 106,
    name: 'Chris Brown',
    address: '221B Cemetery Lane, Misty Mountains',
    contactNumber: '995 796 322',
    action: ""
  },
]

export default {
  setup () {

    return {
      filter: ref(''),
      columns,
      rows,

      addRow () {
        loading.value = true
        setTimeout(() => {
          const
            index = Math.floor(Math.random() * (rows.value.length + 1)),
            row = originalRows[ Math.floor(Math.random() * originalRows.length) ]

          if (rows.value.length === 0) {
            rowCount.value = 0
          }

          row.id = ++rowCount.value
          const newRow = { ...row } // extend({}, row, { name: `${row.name} (${row.__count})` })
          rows.value = [ ...rows.value.slice(0, index), newRow, ...rows.value.slice(index) ]
          loading.value = false
        }, 500)
      },

      removeRow () {
        loading.value = true
        setTimeout(() => {
          const index = Math.floor(Math.random() * rows.value.length)
          rows.value = [ ...rows.value.slice(0, index), ...rows.value.slice(index + 1) ]
          loading.value = false
        }, 500)
      }
    }
  }
}
</script>
