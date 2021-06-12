<template>
  <el-container>
    <el-header></el-header>
    <el-row>
      <el-form :inline="true">
        <el-form-item class="searchInput">
          <el-input v-model="input" placeholder="请输入关键词" size="small" style="width: 100%;"></el-input>
        </el-form-item>
        <el-form-item class="searchSelect">
          <el-select v-model="category" size="small">
            <el-option
                v-for="item in categoryList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item class="searchSelect">
          <el-select v-model="secTime" size="small">
            <el-option
                v-for="item in secTimeList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" size="small" @click="search">搜索</el-button>
        </el-form-item>
      </el-form>
    </el-row>
    <el-row class="activityTable">
      <el-table :data="activityList" stripe border height="400">
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
  data () {
    return {
      currentPage: 1,
      totalNum: 53,
      input: '',
      category: '类别',
      categoryList: [
        {
          value: '0',
          label: '类别'
        }, {
          value: '1',
          label: '衣服'
        }, {
          value: '2',
          label: '生活用品'
        }, {
          value: '3',
          label: '球鞋'
        }
      ],
      secTime: '发布时间',
      secTimeList: [
        {
          value: '0',
          label: '发布时间'
        }, {
          value: '1',
          label: '近三天'
        }, {
          value: '2',
          label: '近一天'
        }, {
          value: '3',
          label: '近七天'
        }, {
          value: '4',
          label: '近一个月'
        },{
          value: '5',
          label: '近三个月'
        }
      ],
      activityList: [ {
        "id":1,
        "publisherId":11,          //发布者ID
        "title":"团立项",   //标题
        "category":1,            //类别
        "announcer":"zzzzcx",    //发布人
        "gmt_create":"2020-2-22",        //发布时间
    "pageInfo":
    {
      "currentPage":1,
        "totalNum":8,
        "totalPage":1
    }
  },
    {
      "id":2,
      "publisherId":11,          //发布者ID
        "title":"团立项",   //标题
        "category":1,            //类别
        "announcer":"zzzzcx",    //发布人
        "gmt_create":"2020-2-22",        //发布时间
      "pageInfo":
      {
        "currentPage":1,
          "totalNum":8,
          "totalPage":1
      }
    }],//活动列表
    }
  },
  methods: {
    search() {
      console.log(this.input);
      console.log(this.category);
      console.log(this.secTime);
    },//搜索

    viewDetail(index,row) {
      console.log(row.id);
    },//查看详情

    handleDelete(index,row) {
      console.log(row.id);
    },//删除

    handleCurrentChange(val) {

    },//改变页面
  }
}
</script>

<style>
.searchInput {
  margin: 0 10%;
}
.searchSelect {
  margin: 0 10%;
}
.activityTable {
  margin: 20px 10%;
}
.page {
  margin: 0 auto;
}
</style>