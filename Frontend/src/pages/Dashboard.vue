<template>
<q-page>
    <h2 style="text-align:center; padding-top: 2px">Dashboard</h2>
    <div style="padding-top 10px; padding-left: 10%; padding-right: 10%;">
        <div class="q-pa-md">
            <q-table title="" :rows="rows" :columns="columns" row-key="name" />
        </div>
    </div>
</q-page>
</template>

<script>
import { defineComponent } from 'vue'

const columns = [ 
        {
            name: 'username',
            label: 'Name',
            field: 'username',
            required: true,
            align: 'left',
        },
        { name: 'taskname', label: 'Taskname', field: 'taskname'},
        { name: 'checkIn', label: 'Start date', field: 'checkIn'},
        { name: 'checkOut', label: 'End date', field: 'checkOut' },
        { name: 'edit', label: 'Edit', field: 'edit' },
        { name: 'delete', label: 'Delete', field: 'delete' }
    ]

export default defineComponent({
    data() {
        return {
            checkin: "null",
            columns,
            rows:[]
        }
    },
    mounted() {
        this.getUserById()
    },
    methods:{
        async getUserById(){
            console.log("test");
            let res = await axios.get("/user/"+this.GetJWTData().upn)
            this.user = res.data
        },
        async getAllTask(){
            let res = await axios.get("/task")
            this.rows = res.data
        },
        GetJWTData() {
            const store = useStore()
            var token = null
            var jwt = this.$store.getters["auth/JWT"]
            if (jwt !== null) {
                var base64Url = jwt.split('.')[1]
                var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/')
                token = JSON.parse(window.atob(base64))
            }
            return token;
        },
        async deleteTask(){
            let res = await axios.delete("/user/" + this.GetJWTData().upn)
            this.user = null
            this.$router.push('/')  
        }
    }
}) 
</script>

<style>

</style>
