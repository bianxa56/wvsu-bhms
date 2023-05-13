<template>
    <q-card class="my-card" flat bordered style="margin: 15px;">
        <q-img src="~assets/chateau/room-1.jpg">
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
