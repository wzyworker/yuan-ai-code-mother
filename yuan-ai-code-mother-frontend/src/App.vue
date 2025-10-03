<script setup lang="ts">
import { useLoginUserStore } from '@/stores/loginUser.ts'
import BasicLayout from '@/layouts/BasicLayout.vue'

const loginUserStore = useLoginUserStore()
loginUserStore.fetchLoginUser()
</script>

<template>
  <BasicLayout />
</template>

<style></style>
