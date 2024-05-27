import request from '@/utils/request'

// 查询座位管理列表
export function listZuowei(query) {
  return request({
    url: '/system/zuowei/list',
    method: 'get',
    params: query
  })
}

// 查询座位管理详细
export function getZuowei(zuoweiId) {
  return request({
    url: '/system/zuowei/' + zuoweiId,
    method: 'get'
  })
}

// 新增座位管理
export function addZuowei(data) {
  return request({
    url: '/system/zuowei',
    method: 'post',
    data: data
  })
}

// 修改座位管理
export function updateZuowei(data) {
  return request({
    url: '/system/zuowei',
    method: 'put',
    data: data
  })
}

// 删除座位管理
export function delZuowei(zuoweiId) {
  return request({
    url: '/system/zuowei/' + zuoweiId,
    method: 'delete'
  })
}
