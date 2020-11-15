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
                    <select v-model="deptName" class="form-control" id="deptName" ref="deptName" >
                    <option v-for="(temp,idx) in deptList" :value="temp">{{temp}}</option>
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
            name: '',
            email: '',
            hireDate: '',
            title: '',
            superV: '',
            deptName: '',
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
            "기획부",
            "인사부",
            "영업부"
            ]
        }
    },
    methods: {
      checkHandler() {
        let err = true;
        let msg = '';
        !this.name && (msg = '이름를 입력해주세요', err = false, this.$refs.name.focus());
        err && !this.email && (msg = '이메일을 입력해주세요', err = false, this.$refs.email.focus());
        err && !this.hireDate && (msg = '고용일을 입력해주세요', err = false, this.$refs.hireDate.focus());
        err && !this.superV && (msg = '관리자를 입력해주세요', err = false, this.$refs.superV.focus());
        err && !this.deptName && (msg = '부서명을 입력해주세요', err = false, this.$refs.deptName.focus());
        err && !this.title && (msg = '직책을 입력해주세요', err = false, this.$refs.title.focus());
        err && !this.salary && (msg = '연봉을 입력해주세요', err = false, this.$refs.salary.focus());
        err && !this.commission && (msg = '커미션을 입력해주세요', err = false, this.$refs.commission.focus());

        if (!err) alert(msg);
        else this.createHandler();
      },

      createHandler() {
        const board = localStorage.getItem('emp_board');
        let newBoard = {
          sequence: 0,
          emps: []
        };
        console.log(board);
        if (board) {
          newBoard = JSON.parse(board);
        }

        newBoard.sequence += 1;
        newBoard.emps.push({
          id: newBoard.sequence,
          name: this.name,
          email: this.email,
          hireDate: this.hireDate,
          title: this.title,
          deptName: this.deptName,
          salary: this.salary,
          commission: this.commission
          
        })
        localStorage.setItem('emp_board', JSON.stringify(newBoard));
        alert('사원등록이 완료되었습니다.');
        location.href = './hrm_list.html';
      },
      moveList() {
        location.href = "./hrm_list.html";
      }
    }
  };
  