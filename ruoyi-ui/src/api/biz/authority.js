import request from '@/utils/request'

// 查询调用key列表
export function listAuthority(query) {
  return request({
    url: '/biz/authority/list',
    method: 'get',
    params: query
  })
}

// 查询调用key详细
export function getAuthority(keyId) {
  return request({
    url: '/biz/authority/' + keyId,
    method: 'get'
  })
}

// 新增调用key
export function addAuthority(data) {
  return request({
    url: '/biz/authority',
    method: 'post',
    data: data
  })
}

// 修改调用key
export function updateAuthority(data) {
  return request({
    url: '/biz/authority',
    method: 'put',
    data: data
  })
}

// 删除调用key
export function delAuthority(keyId) {
  return request({
    url: '/biz/authority/' + keyId,
    method: 'delete'
  })
}

// 导出调用key
export function exportAuthority(query) {
  return request({
    url: '/biz/authority/export',
    method: 'get',
    params: query
  })
}