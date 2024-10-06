import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yuangongList from '../pages/yuangong/list'
import yuangongDetail from '../pages/yuangong/detail'
import yuangongAdd from '../pages/yuangong/add'
import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import jiudiankefangList from '../pages/jiudiankefang/list'
import jiudiankefangDetail from '../pages/jiudiankefang/detail'
import jiudiankefangAdd from '../pages/jiudiankefang/add'
import kefangyudingList from '../pages/kefangyuding/list'
import kefangyudingDetail from '../pages/kefangyuding/detail'
import kefangyudingAdd from '../pages/kefangyuding/add'
import quxiaoyudingList from '../pages/quxiaoyuding/list'
import quxiaoyudingDetail from '../pages/quxiaoyuding/detail'
import quxiaoyudingAdd from '../pages/quxiaoyuding/add'
import ruzhuxinxiList from '../pages/ruzhuxinxi/list'
import ruzhuxinxiDetail from '../pages/ruzhuxinxi/detail'
import ruzhuxinxiAdd from '../pages/ruzhuxinxi/add'
import tuifangpingjiaList from '../pages/tuifangpingjia/list'
import tuifangpingjiaDetail from '../pages/tuifangpingjia/detail'
import tuifangpingjiaAdd from '../pages/tuifangpingjia/add'
import caiwuxinxiList from '../pages/caiwuxinxi/list'
import caiwuxinxiDetail from '../pages/caiwuxinxi/detail'
import caiwuxinxiAdd from '../pages/caiwuxinxi/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yuangong',
					component: yuangongList
				},
				{
					path: 'yuangongDetail',
					component: yuangongDetail
				},
				{
					path: 'yuangongAdd',
					component: yuangongAdd
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'jiudiankefang',
					component: jiudiankefangList
				},
				{
					path: 'jiudiankefangDetail',
					component: jiudiankefangDetail
				},
				{
					path: 'jiudiankefangAdd',
					component: jiudiankefangAdd
				},
				{
					path: 'kefangyuding',
					component: kefangyudingList
				},
				{
					path: 'kefangyudingDetail',
					component: kefangyudingDetail
				},
				{
					path: 'kefangyudingAdd',
					component: kefangyudingAdd
				},
				{
					path: 'quxiaoyuding',
					component: quxiaoyudingList
				},
				{
					path: 'quxiaoyudingDetail',
					component: quxiaoyudingDetail
				},
				{
					path: 'quxiaoyudingAdd',
					component: quxiaoyudingAdd
				},
				{
					path: 'ruzhuxinxi',
					component: ruzhuxinxiList
				},
				{
					path: 'ruzhuxinxiDetail',
					component: ruzhuxinxiDetail
				},
				{
					path: 'ruzhuxinxiAdd',
					component: ruzhuxinxiAdd
				},
				{
					path: 'tuifangpingjia',
					component: tuifangpingjiaList
				},
				{
					path: 'tuifangpingjiaDetail',
					component: tuifangpingjiaDetail
				},
				{
					path: 'tuifangpingjiaAdd',
					component: tuifangpingjiaAdd
				},
				{
					path: 'caiwuxinxi',
					component: caiwuxinxiList
				},
				{
					path: 'caiwuxinxiDetail',
					component: caiwuxinxiDetail
				},
				{
					path: 'caiwuxinxiAdd',
					component: caiwuxinxiAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
