import request from '@/utils/request'

// 查询系统镜像列表
export function listImage(query) {
  return request({
    url: '/docker/image/list',
    method: 'get',
    params: query
  })
}

// 查询系统镜像详细
export function getImage(id) {
  return request({
    url: '/docker/image/' + id,
    method: 'get'
  })
}

// 新增系统镜像
export function addImage(data) {
  return request({
    url: '/docker/image',
    method: 'post',
    data: data
  })
}

// 修改系统镜像
export function updateImage(data) {
  return request({
    url: '/docker/image',
    method: 'put',
    data: data
  })
}

// 删除系统镜像
export function delImage(id) {
  return request({
    url: '/docker/image/' + id,
    method: 'delete'
  })
}

// 导出系统镜像
export function exportImage(query) {
  return request({
    url: '/docker/image/export',
    method: 'get',
    params: query
  })
}