
<template>
  <div class="col">
    <q-img src="~assets/chateau/bh.jpg"  style="height: 300px;">
      <div class="absolute-full text-h3 flex flex-center">
      </div>
    </q-img>
  </div>

  <div class="col" style="padding: 15px; ">
    <div class="text-h4 flex flex-center">
      Find your ideal living space
    </div>
  </div>

  <div class="row q-col-gutter-md">
    <!-- Room 1-->
    <div class="col-4">
      <room-type/>
    </div>
    <!-- Room 2-->
    <div class="col-4">
      <q-card class="my-card" flat bordered style="margin: 15px;">
        <q-img src="~assets/chateau/room-2.jpg" />

        <q-card-section>
          <div class="row no-wrap items-center">
            <div class="col text-h6 ellipsis">
              Room 2
            </div>
          </div>

        </q-card-section>

        <q-card-section class="q-pt-none">
          <div class="text-subtitle1">
            ₱6,000.00・Ground Floor
          </div>
          <div class="text-subtitle1">
            Good for 2 persons only
          </div>
          <div class="text-caption text-grey cursor-pointer"
               :class = "hover ? '' : 'ellipsis-3-lines'"
               @mouseover="hover = true"
               @mouseleave="hover = false">
            Indulge in the comfort and convenience of Room 2, featuring a private CR,
            entertainment with a TV, refreshing air conditioning, convenient refrigerator,
            and a personal cabinet for your belongings. Plus, with a fully-equipped
            shared kitchen, you'll have everything you need to make yourself at home
            and connect with other travelers.
          </div>
        </q-card-section>
        <q-separator />
      </q-card>
    </div>
    <!-- Room 5-->
    <div class="col-4">
      <q-card class="my-card" flat bordered style="margin: 15px;">
        <q-img src="~assets/chateau/room-5.jpg" />

        <q-card-section>
          <div class="row no-wrap items-center">
            <div class="col text-h6 ellipsis">
              Room 5
            </div>
          </div>

        </q-card-section>

        <q-card-section class="q-pt-none">
          <div class="text-subtitle1">
            ₱9,000.00・Ground Floor
          </div>
          <div class="text-subtitle1">
            Good for 2 persons only
          </div>
          <div class="text-caption text-grey cursor-pointer"
               :class = "hover ? '' : 'ellipsis-3-lines'"
               @mouseover="hover = true"
               @mouseleave="hover = false">
            Treat yourself to the ultimate home-away-from-home experience in Room 5,
            boasting a fully-equipped kitchen with your own utilities,
            a spacious and comfortable bed, air conditioning, a dining table for meals and work,
            ample storage space, and a private CR to unwind in complete privacy.
          </div>
        </q-card-section>

        <q-separator />
      </q-card>
    </div>
  </div>

  <div class="row q-col-gutter-md">
    <!--  Room 6-->
    <div class="col-4">
      <q-card class="my-card" flat bordered style="margin: 15px;">
        <q-img src="~assets/chateau/room-6.jpg">
        </q-img>
        <q-card-section>
          <div class="row no-wrap items-center">
            <div class="col text-h6 ellipsis">
              Room 6
            </div>
          </div>

        </q-card-section>

        <q-card-section class="q-pt-none">
          <div class="text-subtitle1">
            ₱6,500.00・Second Floor
          </div>
          <div class="text-subtitle1">
            Good for 2 persons only
          </div>
          <div class="text-caption text-grey cursor-pointer"
               :class = "hover ? '' : 'ellipsis-3-lines'"
               @mouseover="hover = true"
               @mouseleave="hover = false">
            Experience the ultimate in comfort and convenience with Room 1,
            boasting a generous living space complete with a private CR,
            entertainment with a TV, refreshing air conditioning, convenient refrigerator,
            and access to fully-equipped shared kitchen amenities.
          </div>
        </q-card-section>

        <q-separator />
      </q-card>
    </div>
    <!--  Room 8-->
    <div class="col-4">
      <q-card class="my-card" flat bordered style="margin: 15px;">
        <q-img src="~assets/chateau/room-8.jpg" />

        <q-card-section>
          <div class="row no-wrap items-center">
            <div class="col text-h6 ellipsis">
              Room 8
            </div>
          </div>

        </q-card-section>

        <q-card-section class="q-pt-none">
          <div class="text-subtitle1">
            ₱10,000.00・Second Floor
          </div>
          <div class="text-subtitle1">
            Good for 2 persons only
          </div>
          <div class="text-caption text-grey cursor-pointer"
               :class = "hover ? '' : 'ellipsis-3-lines'"
               @mouseover="hover = true"
               @mouseleave="hover = false">
            Indulge in the comfort and convenience of Room 2, featuring a private CR,
            entertainment with a TV, refreshing air conditioning, convenient refrigerator,
            and a personal cabinet for your belongings. Plus, with a fully-equipped
            shared kitchen, you'll have everything you need to make yourself at home
            and connect with other travelers.
          </div>
        </q-card-section>

        <q-separator />
      </q-card>
    </div>
    <!--  Room 9-->
    <div class="col-4">
      <q-card class="my-card" flat bordered style="margin: 15px;">
        <q-img src="~assets/chateau/room-9.jpg" />

        <q-card-section>
          <div class="row no-wrap items-center">
            <div class="col text-h6 ellipsis">
              Room 9
            </div>
          </div>

        </q-card-section>

        <q-card-section class="q-pt-none">
          <div class="text-subtitle1">
            ₱7,000.00・Second Floor
          </div>
          <div class="text-subtitle1">
            Good for 2 persons only
          </div>
          <div class="text-caption text-grey cursor-pointer"
               :class = "hover ? '' : 'ellipsis-3-lines'"
               @mouseover="hover = true"
               @mouseleave="hover = false">
            Treat yourself to the ultimate home-away-from-home experience in Room 5,
            boasting a fully-equipped kitchen with your own utilities,
            a spacious and comfortable bed, air conditioning, a dining table for meals and work,
            ample storage space, and a private CR to unwind in complete privacy.
          </div>
        </q-card-section>

        <q-separator />
      </q-card>
    </div>
  </div>

  <div class="row q-col-gutter-md">
    <!--  Room 11-->
    <div class="col-4">
      <q-card class="my-card" flat bordered style="margin: 15px;">
        <q-img src="~assets/chateau/room-11.jpg">
        </q-img>
        <q-card-section>
          <div class="row no-wrap items-center">
            <div class="col text-h6 ellipsis">
              Room 11
            </div>
          </div>

        </q-card-section>

        <q-card-section class="q-pt-none">
          <div class="text-subtitle1">
            ₱6,500.00・Second Floor
          </div>
          <div class="text-subtitle1">
            Good for 2 persons only
          </div>
          <div class="text-caption text-grey cursor-pointer"
               :class = "hover ? '' : 'ellipsis-3-lines'"
               @mouseover="hover = true"
               @mouseleave="hover = false">
            Experience the ultimate in comfort and convenience with Room 1,
            boasting a generous living space complete with a private CR,
            entertainment with a TV, refreshing air conditioning, convenient refrigerator,
            and access to fully-equipped shared kitchen amenities.
          </div>
        </q-card-section>

        <q-separator />
      </q-card>
    </div>
    <!--  Room 12-->
    <div class="col-4">
      <q-card class="my-card" flat bordered style="margin: 15px;">
        <q-img src="~assets/chateau/room-12.jpg" />

        <q-card-section>
          <div class="row no-wrap items-center">
            <div class="col text-h6 ellipsis">
              Room 12
            </div>
          </div>

        </q-card-section>

        <q-card-section class="q-pt-none">
          <div class="text-subtitle1">
            ₱10,000.00・Second Floor
          </div>
          <div class="text-subtitle1">
            Good for 2 persons only
          </div>
          <div class="text-caption text-grey cursor-pointer"
               :class = "hover ? '' : 'ellipsis-3-lines'"
               @mouseover="hover = true"
               @mouseleave="hover = false">
            Indulge in the comfort and convenience of Room 2, featuring a private CR,
            entertainment with a TV, refreshing air conditioning, convenient refrigerator,
            and a personal cabinet for your belongings. Plus, with a fully-equipped
            shared kitchen, you'll have everything you need to make yourself at home
            and connect with other travelers.
          </div>
        </q-card-section>

        <q-separator />
      </q-card>
    </div>
    <!--  Room 13-->
    <div class="col-4">
      <q-card class="my-card" flat bordered style="margin: 15px;">
        <q-img src="~assets/chateau/room-14.jpg" />

        <q-card-section>
          <div class="row no-wrap items-center">
            <div class="col text-h6 ellipsis">
              Room 14
            </div>
          </div>

        </q-card-section>

        <q-card-section class="q-pt-none">
          <div class="text-subtitle1">
            ₱7,000.00・Second Floor
          </div>
          <div class="text-subtitle1">
            Good for 2 persons only
          </div>
          <div class="text-caption text-grey cursor-pointer"
               :class = "hover ? '' : 'ellipsis-3-lines'"
               @mouseover="hover = true"
               @mouseleave="hover = false">
            Treat yourself to the ultimate home-away-from-home experience in Room 5,
            boasting a fully-equipped kitchen with your own utilities,
            a spacious and comfortable bed, air conditioning, a dining table for meals and work,
            ample storage space, and a private CR to unwind in complete privacy.
          </div>
        </q-card-section>

        <q-separator />
      </q-card>
    </div>
  </div>

  <div class="row q-col-gutter-md">
    <!--  Room 14-->
    <div class="col-4">
      <q-card class="my-card" flat bordered style="margin: 15px;">
        <q-img src="~assets/chateau/room-15.jpg">
        </q-img>
        <q-card-section>
          <div class="row no-wrap items-center">
            <div class="col text-h6 ellipsis">
              Room 15
            </div>
          </div>

        </q-card-section>

        <q-card-section class="q-pt-none">
          <div class="text-subtitle1">
            ₱6,500.00・Ground Floor
          </div>
          <div class="text-subtitle1">
            Good for 2 persons only
          </div>
          <div class="text-caption text-grey cursor-pointer"
               :class = "hover ? '' : 'ellipsis-3-lines'"
               @mouseover="hover = true"
               @mouseleave="hover = false">
            Experience the ultimate in comfort and convenience with Room 1,
            boasting a generous living space complete with a private CR,
            entertainment with a TV, refreshing air conditioning, convenient refrigerator,
            and access to fully-equipped shared kitchen amenities.
          </div>
        </q-card-section>

        <q-separator />
      </q-card>
    </div>
    <!--  Room 17-->
    <div class="col-4">
      <q-card class="my-card" flat bordered style="margin: 15px;">
        <q-img src="~assets/chateau/room-17.jpg" />

        <q-card-section>
          <div class="row no-wrap items-center">
            <div class="col text-h6 ellipsis">
              Room 17
            </div>
          </div>

        </q-card-section>

        <q-card-section class="q-pt-none">
          <div class="text-subtitle1">
            ₱10,000.00・Ground Floor
          </div>
          <div class="text-subtitle1">
            Good for 2 persons only
          </div>
          <div class="text-caption text-grey cursor-pointer"
               :class = "hover ? '' : 'ellipsis-3-lines'"
               @mouseover="hover = true"
               @mouseleave="hover = false">
            Indulge in the comfort and convenience of Room 2, featuring a private CR,
            entertainment with a TV, refreshing air conditioning, convenient refrigerator,
            and a personal cabinet for your belongings. Plus, with a fully-equipped
            shared kitchen, you'll have everything you need to make yourself at home
            and connect with other travelers.
          </div>
        </q-card-section>

        <q-separator />
      </q-card>
    </div>
  </div>
</template>

<style scoped lang="sass">
.my-card
  width: 100%
  max-width: 400px
//color: $lime-10

.q-item-section--side
  justify-content: flex-end

.absolute-full text-h3 flex flex-center

</style>

<script>
import {ref} from 'vue'
import axios from "axios";
import RoomType from "components/RoomType.vue";

export default {
  components: {RoomType},

  data() {
    return {
      hover: false,
      rows: []
    }
  },
  async created () {
    const response = await axios.get('/api/room/findAll')
    this.rows = response.data
    console.log(this.rows)
  },

  setup() {
    const single = ref(null)
    const multiple = ref(null)
    const text = ref('')

    return {
      single,
      multiple,
      text,
      model: ref(10),
      time: ref(''),
      date: ref('')
    }
  }
}
</script>
