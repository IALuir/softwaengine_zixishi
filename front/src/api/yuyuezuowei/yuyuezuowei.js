import request from '@/utils/request'

// 查询列表
export function getYuyueList(query) {
    return request({
        url: '/yuyue/zuowei/list',
        method: 'get',
        params: query
    })
}

// 查询详细
export function getYuyueByyuyueId(yuyueId) {
    return request({
        url: '/yuyue/zuowei/' + yuyueId,
        method: 'get'
    })
}

export function delYuyue(yuyueId) {
    return request({
        url: '/yuyue/zuowei/' + yuyueId,
        method: 'delete'
    })
}

export function updateYuyue(data) {
    return request({
        url: '/yuyue/zuowei',
        method: 'put',
        data: data
    })
}

export function addYuyue(data) {
    return request({
        url: '/yuyue/zuowei',
        method: 'post',
        data: data
    })
}

// 查询座位信息
export function getZuoweiByZuoweiId(zuoweiId) {
    return request({
        url: '/yuyue/zuowei/shenqing/' + zuoweiId,
        method: 'get'
    })
}

// 根据座位查询预约信息
export function getYuyueByZuoweiId(zuoweiId) {
    return request({
        url: '/yuyue/zuowei/ybz/' + zuoweiId,
        method: 'get'
    })
}

// 查询用户预约数量
export function getYuyueNumberByUserId(userId) {
    return request({
        url: '/yuyue/zuowei/ynbu/' + userId,
        method: 'get'
    })
}
