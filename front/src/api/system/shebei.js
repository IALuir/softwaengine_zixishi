import request from '@/utils/request'

// 查询角色列表
export function listshebei(query) {
    return request({
        url: '/system/shebei/list',
        method: 'get',
        params: query
    })
}
