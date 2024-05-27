import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

// 查询座位列表
export function listSeat(query) {
    return request({
        url: '/system/seat/list',
        method: 'get',
        params: query
    })
}

// 查询座位详细
export function getSeat(seatId) {
    return request({
        url: '/system/seat/' + parseStrEmpty(seatId),
        method: 'get'
    })
}

// 修改座位状态
export function changeSeatStatus(seatId, status) {
    const data = {
        seatId,
        status
    }
    return request({
        url: '/system/seat/changeStatus',
        method: 'put',
        data: data
    })
}

// 新增座位
export function addSeat(data) {
    return request({
        url: '/system/seat',
        method: 'post',
        data: data
    })
}

// 修改座位
export function updateSeat(data) {
    return request({
        url: '/system/seat',
        method: 'put',
        data: data
    })
}

// 删除座位
export function delSeat(seatId) {
    return request({
        url: '/system/seat/' + seatId,
        method: 'delete'
    })
}

// 查询部门下拉树结构
export function deptTreeSelect() {
    return request({
        url: '/system/seat/deptTree',
        method: 'get'
    })
}
