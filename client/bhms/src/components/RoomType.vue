<template>
    <q-card class="my-card" flat bordered style="margin: 15px;">
        <q-img src="~assets/chateau/room-1.jpg">
        </q-img>
        <q-card-section>
            <div class="row no-wrap items-center">
                <div class="col text-h6 ellipsis">
                    Room 1
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
                 :class="hover ? '' : 'ellipsis-3-lines'"
                 @mouseover="hover = true"
                 @mouseleave="hover = false">
                Experience the ultimate in comfort and convenience with Room 1,
                boasting a generous living space complete with a private CR,
                entertainment with a TV, refreshing air conditioning, convenient refrigerator,
                and access to fully-equipped shared kitchen amenities.
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
    }
}
</script>
<style scoped lang="sass">
.my-card
  width: 100%
  max-width: 400px
//color: $lime-10

.absolute-full text-h3 flex flex-center

</style>
