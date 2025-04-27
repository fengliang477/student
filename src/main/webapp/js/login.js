// 获取DOM元素
const button = document.querySelector('.button');
const usernameInput = document.querySelector('input[name="username"]');
const passwordInput = document.querySelector('input[name="password"]');

// 计算两点间距离
const distanceBetween = (p1x, p1y, p2x, p2y) => {
    const dx = p1x - p2x;
    const dy = p1y - p2y;
    return Math.sqrt(dx*dx + dy*dy);
};

// 鼠标移动交互效果
document.addEventListener('mousemove', (event) => {
    if(usernameInput.value && passwordInput.value) {
        return;
    }

    const radius = Math.max(button.offsetWidth * 0.75, button.offsetHeight * 0.75, 100);
    const bx = button.offsetLeft + button.offsetWidth / 2;
    const by = button.offsetTop + button.offsetHeight / 2;

    const dist = distanceBetween(event.clientX, event.clientY, bx, by) * 2;
    const angle = Math.atan2(event.clientY - by, event.clientX - bx);

    const ox = -1 * Math.cos(angle) * Math.max((radius - dist), 0);
    const oy = -1 * Math.sin(angle) * Math.max((radius - dist), 0);

    button.style.transform = `translate(${ox}px, ${oy}px)`;
    button.style.transition = 'all 0.1s ease';
    button.style.boxShadow = `0px ${Math.abs(oy)}px ${Math.abs(oy)/radius*40}px rgba(0,0,0,0.15)`;
});

// 登录函数
function login() {
    alert(`登录信息\n用户名: ${usernameInput.value}\n密码: ${passwordInput.value}`);
}

// 绑定点击事件
button.addEventListener('click', login);