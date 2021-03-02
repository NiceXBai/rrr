import request from '@/utils/request'

// 查询用户信息列表
export function listInfo(query) {
  return request({
    url: '/biz/info/list',
    method: 'get',
    params: query
  })
}

// 查询用户信息详细
export function getInfo(id) {
  return request({
    url: '/biz/info/' + id,
    method: 'get'
  })
}

// 新增用户信息
export function addInfo(data) {
  return request({
    url: '/biz/info',
    method: 'post',
    data: data
  })
}

// 修改用户信息
export function updateInfo(data) {
  return request({
    url: '/biz/info',
    method: 'put',
    data: data
  })
}

// 删除用户信息
export function delInfo(id) {
  return request({
    url: '/biz/info/' + id,
    method: 'delete'
  })
}

// 导出用户信息
export function exportInfo(query) {
  return request({
    url: '/biz/info/export',
    method: 'get',
    params: query
  })
}