import Vue from 'vue'
import Router from 'vue-router'
import goodsDetail from './views/goodsDetail.vue'
import taskDetail from './views/taskDetail.vue'
import goodsList from "./views/goodsList.vue";
import taskList from "./views/taskList.vue";
import activityList from "./views/activityList.vue";
import PageActivity from './views/PageActivity.vue'
import PageGoods from './views/PageGoods.vue'
import PageHome from './views/PageHome.vue'
import PageTask from './views/PageTask.vue'




Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    // {
    //   path: '/',
    //   name: 'home',
    //   component: Home
    // },
    {
      path: '/goodsDetail',
      name: 'goodsDetail',
      component: goodsDetail
    },
    {
      path: '/taskDetail',
      name: 'taskDetail',
      component: taskDetail
    },
    {
      path: '/goodsList',
      name: 'goodsList',
      component: goodsList
    },
    {
      path: '/taskList',
      name: 'taskList',
      component: taskList
    },
    {
      path: '/activityList',
      name: 'activityList',
      component: activityList
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    },
    {
      path:'/',
      component:PageHome
    },
    {
      path:'/activity',
      component:PageActivity
    },
    {
      path:'/goods',
      component:PageGoods
    },
    {
      path:'/task',
      component:PageTask
    }
  ]
})
