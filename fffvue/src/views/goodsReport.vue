<template>
  <el-container>
    <el-header></el-header>
    <el-row class="goodsTable">
      <el-table :data="goodsList" stripe border height="400">
        <el-table-column prop="id" label="序号"></el-table-column>
        <el-table-column prop="category" label="类别"></el-table-column>
        <el-table-column prop="title" label="标题"></el-table-column>
        <el-table-column prop="announcer" label="发布人"></el-table-column>
        <el-table-column prop="gmt_create" label="发布时间"></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
                size="mini"
                @click="viewDetail(scope.$index, scope.row)">查看详情</el-button>
            <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-row>
    <div class="page">
      <el-pagination
          @current-change="handleCurrentChange"
          @pre-click="handleCurrentChange"
          @next-click="handleCurrentChange"
          :current-page.sync="currentPage"
          :page-size="10"
          layout="total, prev, pager, next"
          :total="totalNum">
      </el-pagination>
    </div>
  </el-container>

</template>

<script>
export default {
  name: "reportList"
}
</script>

<style scoped>

</style>