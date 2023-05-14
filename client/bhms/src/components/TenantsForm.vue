<template>
  <q-dialog v-model="dialogOpened" @before-show="initForm" @before-hide="resetForm">
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
            <q-btn flat color="primary" style="padding-left: 10px; padding-right: 10px;" @click="saveTenant">SAVE TENANT</q-btn>
            <q-btn flat color="primary" style="padding-left: 10px; padding-right: 10px;" @click="closeDialog">CLOSE</q-btn>
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
    opened: Boolean,
    data: Object
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
        id: 0,
        firstName: "",
        lastName: "",
        address: "",
        contactNumber: "",
        dialogOpened: false
      }
    }
  },
  methods: {
    async saveTenant() {
      try {
        let response = null
        if (this.tenant.id) {
          response = await axios.post("/api/tenant/update", this.tenant)
        } else {
          response = await axios.post("/api/tenant/create", this.tenant)
        }
        console.log(response.data)
        this.notifySuccess('Tenant successfully saved.')
      } catch (error) {
        console.log(error)
        this.notifyError(error)
      }

      this.closeDialog()
    },
    initForm () {
      if (this.data) {
        this.tenant.id = this.data.id
        this.tenant.firstName = this.data.firstName
        this.tenant.lastName = this.data.lastName
        this.tenant.address = this.data.address
        this.tenant.contactNumber = this.data.contactNumber
      }
    },
    resetForm () {
      if (this.tenant) {
        this.tenant.id = 0
        this.tenant.firstName = ""
        this.tenant.lastName = ""
        this.tenant.address = ""
        this.tenant.contactNumber = ""
      }
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
