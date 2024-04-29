import request from '@/utils/request'

export function getcarposition(carId) {
    return request({
        url: '/system/carposition/' + carId,
        method: 'get'
    })
}

export function getcarpositionlist() {
    return request({
        url: '/system/carposition/list',
        method: 'get'
    })
}

export function getcarpositionCarnumIdlist(carnumId) {
    return request({
        url: '/system/carposition/carnumidlist/'+carnumId,
        method: 'get'
    })
}

export function addtimedata(data) {
    return request({
        url: '/system/carposition/carnumidlist/addtemp',
        method: 'post',
        data: data
    })
}