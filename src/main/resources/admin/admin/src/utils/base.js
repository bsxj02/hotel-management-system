const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootgq8885n3/",
            name: "springbootgq8885n3",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootgq8885n3/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "酒店管理系统的设计与实现"
        } 
    }
}
export default base
