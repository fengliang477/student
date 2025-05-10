function getsUserData() {
    fetch('/list-student-users', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => response.json())
        .then(data => {
            // 在控制台打印用户数据
            console.log(data);
            // 将用户数据渲染到页面上
            // 此处保留一个用户数据不清空的bug
            data.forEach(user => {
                const tr = document.createElement('tr');
                const tdId = document.createElement('td');
                const tdName = document.createElement('td');
                const tdSex = document.createElement('td');
                const tdAge = document.createElement('td');
                const tdOperate = document.createElement('td');
                const tdPhone = document.createElement('td');
                const tdEmail = document.createElement('td');
                const buttonEdit = document.createElement('button');
                const buttonDelete = document.createElement('button');
                buttonEdit.innerText = '编辑';
                buttonDelete.innerText = '删除';

                tdId.innerText = user.id;
                tdName.innerText = user.name;
                tdSex.innerText = user.sex;
                tdAge.innerText = user.age;
                tdPhone.innerText = user.phone;
                tdEmail.innerText = user.email;
                tr.appendChild(tdId);
                tr.appendChild(tdName);
                tr.appendChild(tdSex);
                tr.appendChild(tdAge);
                tr.appendChild(tdPhone);
                tr.appendChild(tdEmail);
                tdOperate.appendChild(buttonEdit);
                tdOperate.appendChild(buttonDelete);
                tr.appendChild(tdOperate);
                document.querySelector('tbody').appendChild(tr);
            })
        })
}

function gettUserData() {
    fetch('/list-teacher-users', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => response.json())
        .then(data => {
            // 在控制台打印用户数据
            console.log(data);
            // 将用户数据渲染到页面上
            // 此处保留一个用户数据不清空的bug
            data.forEach(user => {
                const tr = document.createElement('tr');
                const tdId = document.createElement('td');
                const tdName = document.createElement('td');
                const tdSex = document.createElement('td');
                const tdAge = document.createElement('td');
                const tdOperate = document.createElement('td');
                const tdPhone = document.createElement('td');
                const tdEmail = document.createElement('td');
                const buttonEdit = document.createElement('button');
                const buttonDelete = document.createElement('button');
                buttonEdit.innerText = '编辑';
                buttonDelete.innerText = '删除';

                tdId.innerText = user.id;
                tdName.innerText = user.name;
                tdSex.innerText = user.sex;
                tdAge.innerText = user.age;
                tdPhone.innerText = user.phone;
                tdEmail.innerText = user.email;
                tr.appendChild(tdId);
                tr.appendChild(tdName);
                tr.appendChild(tdSex);
                tr.appendChild(tdAge);
                tr.appendChild(tdPhone);
                tr.appendChild(tdEmail);
                tdOperate.appendChild(buttonEdit);
                tdOperate.appendChild(buttonDelete);
                tr.appendChild(tdOperate);
                document.querySelector('tbody').appendChild(tr);
            })
        })
}
function getcUserData() {
    fetch('/list-sc-users', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => response.json())
        .then(data => {
            // 在控制台打印用户数据
            console.log(data);
            // 将用户数据渲染到页面上
            // 此处保留一个用户数据不清空的bug
            data.forEach(user => {
                const tr = document.createElement('tr');
                const tdId = document.createElement('td');
                const tdName = document.createElement('td');
                const tdCid = document.createElement('td');
                const tdCname = document.createElement('td');
                const tdScore = document.createElement('td');
                const tdOperate = document.createElement('td');
                const tdTname = document.createElement('td');
                const buttonEdit = document.createElement('button');
                const buttonDelete = document.createElement('button');
                buttonEdit.innerText = '编辑';
                buttonDelete.innerText = '删除';

                tdId.innerText = user.id;
                tdName.innerText = user.name;
                tdCid.innerText = user.cid;
                tdCname.innerText = user.cname;
                tdScore.innerText = user.score;
                tdTname.innerText = user.tname;
                tr.appendChild(tdId);
                tr.appendChild(tdName);
                tr.appendChild(tdCid);
                tr.appendChild(tdCname);
                tr.appendChild(tdScore);
                tr.appendChild(tdTname);
                tdOperate.appendChild(buttonEdit);
                tdOperate.appendChild(buttonDelete);
                tr.appendChild(tdOperate);
                document.querySelector('tbody').appendChild(tr);
            })
        })
}