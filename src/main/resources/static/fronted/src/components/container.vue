<template>
  <div class="container">
    <slot>

    </slot>
  </div>
</template>

<script>
  export default {
    name: 'AppContainer'
  }
</script>

<style>
  .container {
    width: 1200px;
    margin: 0 auto;
    box-sizing: border-box;
    display: flex;
  }
</style>