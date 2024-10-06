import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import yuangong from '@/views/modules/yuangong/list'
    import kefangyuding from '@/views/modules/kefangyuding/list'
    import aboutus from '@/views/modules/aboutus/list'
    import quxiaoyuding from '@/views/modules/quxiaoyuding/list'
    import tuifangpingjia from '@/views/modules/tuifangpingjia/list'
    import yonghu from '@/views/modules/yonghu/list'
    import jiudiankefang from '@/views/modules/jiudiankefang/list'
    import caiwuxinxi from '@/views/modules/caiwuxinxi/list'
    import config from '@/views/modules/config/list'
    import ruzhuxinxi from '@/views/modules/ruzhuxinxi/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '公告资讯',
        component: news
      }
      ,{
	path: '/yuangong',
        name: '员工',
        component: yuangong
      }
      ,{
	path: '/kefangyuding',
        name: '客房预订',
        component: kefangyuding
      }
      ,{
	path: '/aboutus',
        name: '关于我们',
        component: aboutus
      }
      ,{
	path: '/quxiaoyuding',
        name: '取消预订',
        component: quxiaoyuding
      }
      ,{
	path: '/tuifangpingjia',
        name: '退房评价',
        component: tuifangpingjia
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/jiudiankefang',
        name: '酒店客房',
        component: jiudiankefang
      }
      ,{
	path: '/caiwuxinxi',
        name: '财务信息',
        component: caiwuxinxi
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/ruzhuxinxi',
        name: '入住信息',
        component: ruzhuxinxi
      }
      ,{
	path: '/newstype',
        name: '公告资讯分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
