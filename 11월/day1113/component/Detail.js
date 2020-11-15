export default {
    template: `
        <div>
            <div class="text-align">
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
                    <tr>
                        <td>{{emp.id}}</td>
                        <td>{{emp.name}}</td>
                        <td>{{emp.dept_id}}</td>
                        <td>{{emp.title}}</td>
                        <td>{{emp.salary}}</td>
                    </tr>
                </table>
                <br />
                <div class="text-center">
                    <router-link :to="'/hrmlist'"><button class="btn btn-primary">목록</button></router-link>
                </div>
            </div>
        </div>
          
      `,
    data: function(){
      return{
          emp: []
      }
    },
    created() {
        const params = new URL(document.location).searchParams;
        axios.get(`http://localhost:8080/ssafy/api/${params.get('id')}`).then(({ data }) => {
        this.emp = data;
        });
    }
  };
  