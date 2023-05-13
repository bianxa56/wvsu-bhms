
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
    <div v-for="row in rows" :key="row.id" class="col-4">
      <room-type :room="row"/>
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
