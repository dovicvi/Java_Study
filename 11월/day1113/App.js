import List from './component/List.js';
import Create from './component/Create.js';
import Detail from './component/Detail.js';

Vue.use(VueRouter);
export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/hrmlist',
      name: 'hrmlist',
      component: List,
    },
    {
      path: '/hrmcreate',
      name: 'hrmcreate',
      component: Create,
    },
    {
      path: '/hrmdetail',
      name: 'hrmdetail',
      component: Detail,
    }    
  ],
});
