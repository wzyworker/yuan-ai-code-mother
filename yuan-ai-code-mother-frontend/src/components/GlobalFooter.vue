<template>
  <a-layout-footer class="footer">
    <div class="footer-content">
      <p class="copyright">
        <a
          href="https://space.bilibili.com/57899203?spm_id_from=333.1007.0.0"
          target="_blank"
          rel="noopener noreferrer"
          class="author-link"
        >
          yuan-ai-code-mother by pf牛马远
        </a>
      </p>
    </div>
  </a-layout-footer>
</template>

<script setup lang="ts">
// 无需额外的响应式数据
</script>

<style scoped>
.footer {
  background: #efefef;
  text-align: center;
  padding: 20px;
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
}

.copyright {
  margin: 0;
  color: #666;
  font-size: 14px;
}
</style>
