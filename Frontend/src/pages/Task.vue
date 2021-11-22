<template>
<q-page>
    <div class="LoginPage">
        <h3 style="text-align: center;">Create new task</h3>
        <div style="max-width: 400px;" class="q-mx-auto">
            <form @submit="validateAndSubmit">
                <q-input v-model="taskname" type="text" class="form-control" label="Taskname" /> <br/>
                <q-input filled v-model="checkInDate" lable="Start date">
                    <template v-slot:prepend>
                        <q-icon name="event" class="cursor-pointer">
                        <q-popup-proxy cover transition-show="scale" transition-hide="scale">
                            <q-date v-model="checkInDate" mask="YYYY-MM-DD HH:mm">
                            <div class="row items-center justify-end">
                                <q-btn v-close-popup label="Close" color="primary" flat />
                            </div>
                            </q-date>
                        </q-popup-proxy>
                        </q-icon>
                    </template>

                    <template v-slot:append>
                        <q-icon name="access_time" class="cursor-pointer">
                        <q-popup-proxy cover transition-show="scale" transition-hide="scale">
                            <q-time v-model="checkInDate" mask="YYYY-MM-DD HH:mm" format24h>
                            <div class="row items-center justify-end">
                                <q-btn v-close-popup label="Close" color="primary" flat />
                            </div>
                            </q-time>
                        </q-popup-proxy>
                        </q-icon>
                    </template>
                </q-input> <br/>
            <q-input filled v-model="checkOutDate" lable="End date">
                    <template v-slot:prepend>
                        <q-icon name="event" class="cursor-pointer">
                        <q-popup-proxy cover transition-show="scale" transition-hide="scale">
                            <q-date v-model="checkOutDate" mask="YYYY-MM-DD HH:mm">
                            <div class="row items-center justify-end">
                                <q-btn v-close-popup label="Close" color="primary" flat />
                            </div>
                            </q-date>
                        </q-popup-proxy>
                        </q-icon>
                    </template>

                    <template v-slot:append>
                        <q-icon name="access_time" class="cursor-pointer">
                        <q-popup-proxy cover transition-show="scale" transition-hide="scale">
                            <q-time v-model="checkOutDate" mask="YYYY-MM-DD HH:mm" format24h>
                            <div class="row items-center justify-end">
                                <q-btn v-close-popup label="Close" color="primary" flat />
                            </div>
                            </q-time>
                        </q-popup-proxy>
                        </q-icon>
                    </template>
                </q-input>
            </form>
            <div style="padding-top: 10px;">
            <q-btn class="q-mt-xl" style="margin-right: 10px;" color="primary" label="Create Task" type="submit" @click="validateAndSubmit" />
            <q-btn class="q-mt-xl" color="dark" label="Back to Dashboard" unelevated to="/home" @click="goToLogin" />
        </div>
        </div>
    </div>
</q-page>
</template>

<script>
import { defineComponent } from 'vue'
import { ref } from 'vue'

export default defineComponent({
    name: 'Task',
    data() {
        return {
            taskname:"",
            checkInDate: "Start date",
            checkOutDate: "End date",
        }
    },
    methods:{
        async validateAndSubmit(){
            let res = await axios.post("/task", {
                taskname: this.taskname,
                checkIn: this.checkIn,
                checkOut: this.checkOut,
            })
            this.$router.push("/home")
        }
    },
    mounted() {
    },
}) 
</script>

<style>

</style>
