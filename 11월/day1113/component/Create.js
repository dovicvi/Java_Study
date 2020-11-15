export default {
    template: `
    <div>
        <div>
            <table class="table table-bordered table-condensed">
            <colgroup>
                <col width="30%" />
                <col width="70%" />
            </colgroup>
            <tr>
                <th><label for="id">아이디</label></th>
                <td><input type="text" class="form-control" id="id" ref="id" placeholder="아이디" v-model="id"></td>
            </tr> 
            <tr>
                <th><label for="name">이름</label></th>
                <td><input type="text" class="form-control" id="name" ref="name" placeholder="이름" v-model="name"></td>
            </tr>  
            <tr>
                <th><label for="email">이메일</label></th>
                <td><input type="text" class="form-control" id="email" ref="email" placeholder="이메일" v-model="email"></td>
            </tr>
            <tr>
                <th><label for="hireDate">고용일</label></th>
                <td><input type="text" class="form-control" id="hireDate" ref="hireDate" placeholder="연도-월-일" v-model="hireDate"></td>
            </tr>
            <tr>
                <th><label for="superV">관리자</label></th>
                <td><input type="text" class="form-control" id="superV" ref="superV" placeholder="관리자" v-model="superV"></td>
            </tr>
            <tr>
                <th><label for="deptName">부서</label></th>
                <td>
                    <select v-model="dept_id" class="form-control" id="dept_id" ref="dept_id" >
                    <option v-for="(temp,idx) in deptList" :value="temp.did">{{temp.dname}}</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th><label for="title">직책</label></th>
                <td>
                    <select v-model="title" class="form-control" id="title" ref="title" >
                    <option v-for="(temp,idx) in titleList" :value="temp">{{temp}}</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th><label for="salary">연봉</label></th>
                <td><input type="text" class="form-control" id="salary" ref="salary" placeholder="연봉" v-model="salary"></td>
            </tr>
            <tr>
                <th><label for="commission">커미션</label></th>
                <td><input type="text" class="form-control" id="commission" ref="commission" placeholder="커미션" v-model="commission"></td>
            </tr>
            </table>
            <div class="text-center">
            <button class="btn btn-primary" @click="checkHandler">사원추가</button>
            <button class="btn btn-primary" @click="moveList">목록</button>
            </div>
        </div>
    </div>
    `,
    data: function(){
        return{
            id: '',
            name: '',
            email: '',
            hireDate: '',
            title: '',
            superV: '',
            dept_id: '',
            salary: '',
            commission: '',
            titleList: [
            "사장",
            "기획부장",
            "영업부장",
            "총무부장",
            "인사부장",
            "과장",
            "영업대표이사",
            "사원"
            ],
            deptList:[
                {
                    dname: "기획부",
                    did: 110
                },
                {
                    dname: "인사부",
                    did: 118
                },
                {
                    dname: "영업부",
                    did: 102
                }
            ]
        }
    },
    methods: {
      checkHandler() {
        let err = true;
        let msg = '';

        !this.id && (msg = '아이디를 입력해주세요', err = false, this.$refs.id.focus());
        err && !this.name && (msg = '이름를 입력해주세요', err = false, this.$refs.name.focus());
        err && !this.email && (msg = '이메일을 입력해주세요', err = false, this.$refs.email.focus());
        err && !this.hireDate && (msg = '고용일을 입력해주세요', err = false, this.$refs.hireDate.focus());
        err && !this.superV && (msg = '관리자를 입력해주세요', err = false, this.$refs.superV.focus());
        err && !this.dept_id && (msg = '부서명을 입력해주세요', err = false, this.$refs.dept_id.focus());
        err && !this.title && (msg = '직책을 입력해주세요', err = false, this.$refs.title.focus());
        err && !this.salary && (msg = '연봉을 입력해주세요', err = false, this.$refs.salary.focus());
        err && !this.commission && (msg = '커미션을 입력해주세요', err = false, this.$refs.commission.focus());

        if (!err) alert(msg);
        else this.createHandler();
      },

      createHandler() {
        axios.post('http://localhost:8080/ssafy/api/add', {
            id: this.id,
            name: this.name,
            mailid: this.email,
            start_date: this.hireDate,
            title: this.title,
            manager_id: this.superV,
            dept_id: this.dept_id,
            salary: this.salary,
            commission_pct: this.commission
        })
        .then(({ data }) => {
          this.moveList();
        });
      },
      moveList() {
        this.$router.push('/hrmlist');
      }
    }
  };
  