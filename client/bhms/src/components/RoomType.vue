<template>
    <q-card class="my-card" flat bordered style="margin: 15px;">
        <q-img :src="getRoomImage(room.name)">
        </q-img>
        <q-card-section>
            <div class="row no-wrap items-center">
                <div class="col text-h6 ellipsis">
                    {{room.name}}
                </div>
            </div>

        </q-card-section>

        <q-card-section class="q-pt-none">
            <div class="text-subtitle1">
                ₱{{room.monthlyRent.toLocaleString()}}.00・{{room.roomLocation}}
            </div>
            <div class="text-subtitle1">
              {{room.capacity}}
            </div>
            <div class="text-caption text-grey cursor-pointer"
                 :class="hover ? '' : 'ellipsis-3-lines'"
                 @mouseover="hover = true"
                 @mouseleave="hover = false">
                {{room.description}}
            </div>
        </q-card-section>
        <q-separator/>
    </q-card>
</template>
<script>
export default {
    name: 'RoomType',
    data() {
      return {
        hover: false
      }
    },
    methods: {
      getRoomImage(roomName) {
        let img = ""
        console.log(roomName)
        switch(roomName) {
          case "Room 1": return 'room-1.jpg'
          case "Room 2": return 'room-2.jpg'
          case "Room 5": return 'room-5.jpg'
          case "Room 6": return 'room-6.jpg'
          case "Room 8": return 'room-8.jpg'
          case "Room 9": return 'room-9.jpg'
          case "Room 11": return 'room-11.jpg'
          case "Room 12": return 'room-12.jpg'
          case "Room 14": return 'room-14.jpg'
          case "Room 15": return 'room-15.jpg'
          case "Room 17": return 'room-17.jpg'
        }
      }
    },
    props: ['room']
}
</script>

<style scoped lang="sass">
.my-card
  width: 100%
  max-width: 400px
//color: $lime-10

.absolute-full text-h3 flex flex-center

</style>
