<script setup>

</script>

<template>
  <q-card class="my-card">
    <div class="row">
      <div class="col-6">
        <div class="header2">WHO WE ARE</div>
        <div class="img">
          <q-img src="~assets/chateau/bh.jpg"/>
        </div>
      </div>
      <div class="col-6">
        <div class="p-2">
          Chateau D' Alta is an innovative boarding house management system that
          was founded in 2015 by real estate investor and property manager,
          Yolanda Porschwitz. Our mission is to simplify the process of managing
          houses, making it easier and more efficient for property managers and tenants alike.
        </div>
        <div class="header">OUR STORY</div>
        <div class="p-1">
          After years of experience managing multiple properties and tenants,
          Yolanda recognized the need for a comprehensive, user-friendly management
          system for boarding houses. She assembled a team of talented developers
          and property management experts, and together they set out to create Chateau D' Alta.
        </div>
        <div class="p-1">
          The result was a game-changing system that streamlines and simplifies the
          management of boarding houses. Our user-friendly interface makes it easy
          for property managers to manage multiple properties and tenants at once,
          while our transparent approach to rent payment and maintenance reporting
          helps tenants feel secure and supported.
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-6">
        <div class="header" style="margin-top: 30px;">OUR VALUES</div>
        <div class="p-1">
          At Chateau D'Alta, we are committed to providing excellent service to our customers.
          We believe in transparency, honesty, and integrity, and we always put the needs of
          our customers first. We understand the challenges of managing boarding houses, and
          we are here to help make the process easier and more efficient.
        </div>

        <div class="header">OUR TEAM</div>
        <div class="p-1">
          Our team is made up of talented developers, property management experts,
          and customer support professionals. We are passionate about what we do and
          are dedicated to providing the best possible service to our customers.
          We believe that by working together, we can make a real difference in the
          lives of property managers and tenants.
        </div>
      </div>
      <div class="col-6">
        <div class="" style="display: flex; align-items: center;">
          <q-img src="~assets/logo.png"/>
        </div>
      </div>
    </div>
  </q-card>
</template>

<style scoped lang="sass">

.my-card
  color: $lime-10
  margin: 50px
  padding: 20px
  background-color: $lime-1

.header
  margin-bottom: 10px
  font-family: "Century Gothic"
  font-size: 25px
  font-weight: bold
  letter-spacing: 3px
  text-align: center

.header2
  margin-top: 50px
  font-family: "Century Gothic"
  font-size: 25px
  font-weight: bold
  letter-spacing: 3px
  text-align: center

.my-icon
  margin-left: 20px
  margin-top: 20px
  width: 100px
  height: 100px

.img
  padding: 20px
  width: 100%
  margin-top: 10px

.p-1
  margin-bottom: 20px
  font-family: "Century Gothic"
  font-size: 13px
  text-align: center
  padding-right: 10px

.p-2
  margin-bottom: 20px
  font-family: "Century Gothic"
  font-size: 13px
  margin-top: 70px
  text-align: center
  padding-right: 10px

</style>
