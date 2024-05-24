import request from '@/utils/request'

// 查询角色列表
export function listTousu(query) {
  return request({
    url: '/tousufankui/tousu/list',
    method: 'get',
    params: query
  })
}
