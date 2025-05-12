<template>
  <div class="nav-item">
    <router-link :to="to" class="list-group-item list-group-item-action"></router-link>
  </div>
</template>

<script>
  export default {
    name: 'nav-item',
    props: {
      to: {
        type: String,
        required: true
      }
    }
  }

</script>

<style>
  *{
    margin: 0;
    padding: 0;
  }
  .list{
    background-color: #f4f4f4;
    width: 150px;
  }
</style>