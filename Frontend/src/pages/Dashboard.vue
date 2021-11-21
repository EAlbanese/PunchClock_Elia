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

export default defineComponent({
    data() {
        return {
            checkin: "null",
            columns: [ 
                {
                    name: 'desc',
                    label: 'Name',
                    field: 'name',
                    required: true,
                    align: 'left',
                    sortable: true,
                    sort: (a, b, rowA, rowB) => parseInt(a, 10) - parseInt(b, 10),
                    sortOrder: 'ad',
                    format: (val, row) => `${val}%`,
                    style: 'width: 500px',
                    classes: 'my-special-class',
                    headerStyle: 'width: 500px',
                    headerClasses: 'my-special-class'
                },
                { name: 'taskname', label: 'Taskname', field: 'taskname'},
                { name: 'checkIn', label: 'Start date', field: 'checkIn'},
                { name: 'checkOut', label: 'End date', field: 'checkOut' },
                { name: 'edit', label: 'Edit', field: 'edit' },
                { name: 'delete', label: 'Delete', field: 'delete' }
            ]   
        }
    },
    mounted() {
    }
}) 
</script>

<style>

</style>
