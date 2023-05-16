<template>
  <div class="q-pa-md">

    <div class="row">
      <div class="col" style="font-size: 30px">
        <p>Welcome, Admin!</p>
        <div class="row">
          <div class="col-4">
            <div class="q-pa-md row q-gutter-md">
              <q-card class="dashboardCard" style="padding: 5px; width: 100%">
                <q-card-section>
                  <div class="card-title" style="font-size: 20px">
                    Occupied Rooms
                  </div>
                  <div class="row">
                    <div class="col-10" style="padding-left: 10px;  font-size: 50px;">
                      {{ tenants.length }}
                    </div>
                    <div class="col-2">
                      <q-icon name="person" color="lime-10" class="text-primary " size="40px" style="padding-top: 20px;"/>
                    </div>
                  </div>
                  <q-separator style="width: 100%;" size="2px"/>
                </q-card-section>
              </q-card>
            </div>
          </div>
          <div class="col-4">
            <div class="q-pa-md row q-gutter-md">
              <q-card class="dashboardCard" style="padding: 5px; width: 100%">
                <q-card-section>
                  <div class="card-title" style="font-size: 20px">
                    Bed Count
                  </div>
                  <div class="row">
                    <div class="col-10" style="padding-left: 10px;  font-size: 50px;">
                      {{ totalBeds }}
                    </div>
                    <div class="col-2">
                      <q-icon name="bed" color="lime-10" class="text-primary " size="40px" style="padding-top: 20px;"/>
                    </div>
                  </div>
                  <q-separator style="width: 100%;" size="2px"/>
                </q-card-section>
              </q-card>
            </div>
          </div>
          <div class="col-4">
            <div class="q-pa-md row q-gutter-md">
              <q-card class="dashboardCard" style="padding: 5px; width: 100%">
                <q-card-section>
                  <div class="card-title" style="font-size: 20px">
                    Room Count
                  </div>
                  <div class="row">
                    <div class="col-10" style="padding-left: 10px;  font-size: 50px;">
                      {{ totalRooms }}
                    </div>
                    <div class="col-2">
                      <q-icon name="apartment" color="lime-10" class="text-primary " size="40px" style="padding-top: 20px;"/>
                    </div>
                  </div>
                  <q-separator style="width: 100%;" size="2px"/>
                </q-card-section>
              </q-card>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-4">
        <div class="q-pa-md row q-gutter-md">
          <q-card class="dashboardCard" style="padding: 5px; width: 100%">
            <q-card-section>
              <div class="card-title" style="font-size: 20px">
                Total Boarders
              </div>
              <div class="row">
                <div class="col-10" style="padding-left: 10px;  font-size: 50px;">
                  {{ tenants.length }}
                </div>
                <div class="col-2">
                  <q-icon name="person" color="lime-10" class="text-primary " size="40px" style="padding-top: 20px;"/>
                </div>
              </div>
              <q-separator style="width: 100%;" size="2px"/>
            </q-card-section>
          </q-card>
        </div>
      </div>
      <div class="col-4">
        <div class="q-pa-md row q-gutter-md">
          <q-card class="dashboardCard" style="padding: 5px; width: 100%">
            <q-card-section>
              <div class="card-title" style="font-size: 20px">
               Available Beds
              </div>
              <div class="row">
                <div class="col-10" style="padding-left: 10px;  font-size: 50px;">
                  {{availableBeds}}
                </div>
                <div class="col-2">
                  <q-icon name="bed" color="lime-10" class="text-primary " size="40px" style="padding-top: 20px;"/>
                </div>
              </div>
              <q-separator style="width: 100%;" size="2px"/>
            </q-card-section>
          </q-card>
        </div>
      </div>
      <div class="col-4">
        <div class="q-pa-md row q-gutter-md">
          <q-card class="dashboardCard" style="padding: 5px; width: 100%">
            <q-card-section>
              <div class="card-title" style="font-size: 20px">
                Available Rooms
              </div>
              <div class="row">
                <div class="col-10" style="padding-left: 10px;  font-size: 50px;">
                  {{availableRooms}}
                </div>
                <div class="col-2">
                  <q-icon name="apartment" color="lime-10" class="text-primary " size="40px" style="padding-top: 20px;"/>
                </div>
              </div>
              <q-separator style="width: 100%;" size="2px"/>
            </q-card-section>
          </q-card>
        </div>
      </div>
      <div class="" style="width: 100%">
        <div class="q-pa-md row q-gutter-md">
          <q-card class="dashboardCard" style="padding: 5px; width: 100%">
            <q-card-section>
              <div class="card-title" style="font-size: 20px">
                Total collectibles this month
              </div>
              <div class="row">
                <div class="col-10" style="padding-left: 10px;  font-size: 50px;">
                  ₱36, 000.00
                </div>
                <div class="col-2">
                  <q-icon name="payments" color="lime-10" class="text-primary " size="40px" style="padding-top: 20px;"/>
                </div>
              </div>
              <q-separator style="width: 100%;" size="2px"/>
            </q-card-section>
          </q-card>
        </div>
      </div>

    </div>

  </div>
</template>

<style scoped lang="sass">

</style>

<script>
import axios from "axios";

export default {
  data() {
    return {
      tenants: [],
      totalRooms: 20,
      totalBeds: 40

    }
  },
  computed: {
    availableRooms() {
      return this.totalRooms - this.tenants.length;
    },
    availableBeds() {
      return this.totalBeds - this.tenants.length;
    }
  },
  async created () {
    const response = await axios.get('/api/tenant/findAll')
    this.tenants = response.data
    console.log(this.tenants)
  }
}
</script>
