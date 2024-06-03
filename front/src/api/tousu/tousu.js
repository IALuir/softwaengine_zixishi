import request from '@/utils/request'

// 查询角色列表
export function listTousu(query) {
  return request({
    url: '/tousufankui/tousu/list',
    method: 'get',
    params: query
  })
}

export function listFankui(userId) {
  return request({
    url: '/tousufankui/fankui/' + userId,
    method: 'get',
  })
}

// 新增角色
export function addTousu(data) {
  return request({
    url: '/tousufankui/tousu',
    method: 'post',
    data: data
  })
}

// 修改角色
export function updateTousu(data) {
  return request({
    url: '/tousufankui/tousu',
    method: 'put',
    data: data
  })
}

export function delTousu(tousuId) {
  return request({
    url: '/tousufankui/tousu/' + tousuId,
    method: 'delete'
  })
}
export function getTousuBytousuId(tousuId) {
  return request({
    url: '/tousufankui/tousu/' + tousuId,
    method: 'get'
  })
}
