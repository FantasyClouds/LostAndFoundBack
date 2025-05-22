<template>
  <AMISRenderer :schema="schema" :locals="locals" />
</template>
<script setup>
import AMISRenderer from "@/components/AMISRenderer";
import { ref } from "vue";

const schema = {
  type: "page",
  title: "?? AMIS ????",
  body: [
    {
      type: "form",
      mode: "horizontal",
      api: "https://3xsw4ap8wah59.cfc-execute.bj.baidubce.com/api/amis-mock/mock2/form/saveForm",
      body: [
        {
          label: "Name",
          type: "input-text",
          name: "name",
        },
        {
          label: "Email",
          type: "input-email",
          placeholder: "???????",
          name: "email",
        },
        {
          type: 'editor',
          name: 'js',
          label: 'JS',
          language: 'javascript',
        }
      ],
    },
  ],
};
const locals = ref({
  name : "Your Name"
});
</script>
