<template>
  <q-dialog v-model="dialogOpened">
    <q-card>
      <div class="q-pa-md">
        <div class="row">
          <q-img src="~assets/iloilo.jpg"></q-img>
        </div>
        <div class="text-center" style="font-weight: bold; padding: 10px;">
          <h7>"Book your perfect stay in just a few clicks"</h7>
        </div>
        <div class="q-gutter-md" style="max-width: 300px;">
          <q-input filled label-color="black" v-model="tenant.firstName" label="First Name"/> <!--First Name-->
          <q-input filled v-model="tenant.lastName" label-color="black" label="Last Name" /> <!--Last Name-->
          <q-input filled v-model="tenant.address" label-color="black" label="Address" /> <!--Address-->
          <q-input filled v-model="tenant.contactNumber" label-color="black" label="Contact Number" /> <!--Contact Number-->

          <q-card-actions align="center">
            <q-btn flat color="primary" style="padding-left: 10px; padding-right: 10px;" @click="addTenant">ADD TENANT</q-btn>
          </q-card-actions>

        </div>
      </div>
    </q-card>
  </q-dialog>
</template>

<style scoped lang="sass">
.q-pa-md
//padding: 10px
//margin: 20px

</style>

<script>
import { ref } from 'vue'
import axios from "axios"
import { Events } from 'src/events/events'
export default {
  props: {
    opened: Boolean
  },
  emits: [Events.TENANT_DIALOG_OPEN],
  watch: {
    opened(value) {
      this.dialogOpened = value
    }
  },
  data() {
    return {
      tenant: {
        firstName: "",
        lastName: "",
        address: "",
        contactNumber: "",
        dialogOpened: false
      }
    }
  },
  methods: {
    async addTenant() {
      try {
        const response = await axios.post("/api/tenant/create", this.tenant)
        console.log(response.data)
        this.notifySuccess('Tenant successfully added.')
      } catch (error) {
        console.log(error)
        this.notifyError(error)
      }

      this.closeDialog()
    },
      closeDialog() {
      this.dialogOpened = false
      this.$emit(Events.TENANT_DIALOG_OPEN, this.dialogOpened)
    }
  }
}
</script>

<style scoped lang="sass">

</style>
