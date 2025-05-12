<template>
  <AppContainer >
    <NavSide />
    <div class="a3">
      {{msg}}
    </div>
  </AppContainer>

</template>

<script>
import AppContainer from '../components/container.vue';
import NavSide from '../components/nav_side.vue';

export default {
  name: "A3View",
  components: {
    AppContainer,
    NavSide
  },
  computed:{
    msg(){
      return this.$route.query.msg || "默认参数";
    }
  }
};
</script>

<style>
  .a3 {
    margin: 0 auto;
  }
</style>


