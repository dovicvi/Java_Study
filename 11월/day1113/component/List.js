export default {
    template: `
        <div>
            <div class="text-center">
                <input type="text" id="keyword" placeholder="사원이름을 입력하세요">
                <button class="btn btn-primary" @click="search">검색</button>
            </div>

            <div v-if="emps.length">
                <table class="table table-bordered table-condensed">
                    <colgroup>
                        <col width="20%" />
                        <col width="20%" />
                        <col width="20%" />
                        <col width="20%" />
                        <col width="20%" />
                    </colgroup>
                    <tr>
                        <th>사원 아이디</th>
                        <th>사원명</th>
                        <th>부서</th>
                        <th>직책</th>
                        <th>연봉</th>
                    </tr>
                    <tr v-for="(emp, idx) in emps" :key="idx + '_emps'" v-if="!word||emp.name==word">
                        <td><router-link :to="'hrmdetail?id=' + emp.id">{{emp.id}}</router-link></td>
                        <td>{{emp.name}}</td>
                        <td>{{emp.dept_id}}</td>
                        <td>{{emp.title}}</td>
                        <td>{{emp.salary}}</td>
                    </tr>
                </table>
            </div>
            <div v-else class="text-center">
                등록된 사원이 없습니다.
            </div>
            <div class="text-right">
                <router-link :to="'/hrmcreate'"><button class="btn btn-primary">등록</button></router-link>
            </div>
        </div>
          
      `,
    data: function(){
        return{
            word: '',
            emps: []
        }
    },
    created() {
        axios.get('http://localhost:8080/ssafy/api/list').then(({ data }) => {
        this.emps = data;
        });
    },
    methods: {
        search() {
            this.word=document.querySelector('#keyword').value;
        }
    }
};
    