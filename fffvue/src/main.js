import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import echarts from 'echarts'
Vue.prototype.$echarts = echarts

import './plugins/element.js'
import '/dist/fonts/iconfont.css'
import './assets/fonts/download/font_2608416_q83rkcif4ap/iconfont.css'


Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
