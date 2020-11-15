export default {
    template: `
        <div>
            <div class="text-align">
            <template v-for="emp in emps" v-if="emp.id == id">
                <table class="table table-condensed w-25">
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
                    <tr>
                        <td>{{emp.id}}</td>
                        <td>{{emp.name}}</td>
                        <td>{{emp.deptName}}</td>
                        <td>{{emp.title}}</td>
                        <td>{{emp.salary}}</td>
                    </tr>
                </table>
                <br />
                <div class="text-center">
                    <button class="btn btn-primary" @click="moveList">목록</button>
                </div>
            </template>
            </div>
        </div>
          
      `,
    data: function(){
      return{
          id: '',
          emps: []
      }
    },
    created() {
        const params = (new URL(document.location)).searchParams;
        const id = params.get('id');
        this.id = id;
        //console.log(typeof(id));
        //console.log(typeof(this.id));
        const board = localStorage.getItem('emp_board');
        let newBoard = {
            sequence: 0,
            emps: []
        };

        if (board) {
            newBoard = JSON.parse(board);
        } else {
            localStorage.setItem('emp_board', JSON.stringify(newBoard))
        }

        newBoard.emps.sort((a, b) => {
            return -(a.no - b.no);
        });
        this.emps = newBoard.emps;
        //console.log(typeof(this.emps[0].id));
    },
    methods: {
        moveList() {
            location.href = "./hrm_list.html";
        }
    }
  };
  