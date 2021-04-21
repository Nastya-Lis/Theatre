Vue.component('message-row',{
    props: ['message'],
    template:'<div><i>({{message.id}})</i> {{message.text}}</div>'
    }
)
Vue.component('messages-list', {
        props:['messa'],
        template:'<div><message-row v-for="message in messa": message="message" /></div>'
})
var app = new Vue({
    el: '#app',
    template: '<messages-list :messa="messages" />',
    data: {
        messages:[
            {id:'1',text:'Tamara' },
            {id:'2',text:'Victor' },
            {id:'3',text:'Majima' },
        ]
    }
});
