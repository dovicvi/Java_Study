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
                        <td><a :href="'hrm_detail.html?id=' + emp.id">{{emp.id}}</a></td>
                        <td>{{emp.name}}</td>
                        <td>{{emp.deptName}}</td>
                        <td>{{emp.title}}</td>
                        <td>{{emp.salary}}</td>
                    </tr>
                </table>
            </div>
            <div v-else class="text-center">
                등록된 사원이 없습니다.
            </div>
            <div class="text-right">
                <button class="btn btn-primary" @click="movePage">등록</button>
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
    },
    methods: {
        search() {
            this.word=document.querySelector('#keyword').value;
        },
        movePage() {
            location.href = './hrm_create.html';
        }
    }
};
    