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
                :key="item.categoryId"
                :label="item.categoryDesignation"
                :value="item.categoryId">
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
    <el-row class="goodsTable">
      <el-table :data="goodsList" stripe border height="400">
        <el-table-column prop="id" label="序号"></el-table-column>
        <el-table-column prop="category" label="类别"></el-table-column>
        <el-table-column prop="title" label="标题"></el-table-column>
        <el-table-column prop="announcer" label="发布人"></el-table-column>
        <el-table-column prop="gmt_create" label="发布时间"></el-table-column>
        <el-table-column label="操作" width="200">
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
import axios from "axios";
import qs from "qs";

export default {
  data () {
    return {
      currentPage: 1,
      totalNum: 53,
      input: '',
      category: '类别',
      categoryList: [
        { categoryDesignation: "衣服", categoryId: 1 },
      ],
      secTime: '发布时间',
      secTimeList: [
        {
          value: '0',
          label: '发布时间'
        }, {
          value: '3',
          label: '近三天'
        }, {
          value: '1',
          label: '近一天'
        }, {
          value: '7',
          label: '近七天'
        }, {
          value: '30',
          label: '近一个月'
        },{
          value: '90',
          label: '近三个月'
        }
      ],
      goodsList: [ {
        "category":"鞋子",
        "collectState":0,
        "condition":1,
        "id":1,
        "imageLink":"13213",
        "originalPrice":6,
        "price":4,
        "sellerId":1,
        "announcer":"zzzzcx",
        "gmt_create":"2020-1-22",
        "tagList":
            [
              {
                "content":"hhhhh",
                "id":1
              }
            ],
        "title":"hhh",
        "pageInfo":
            {
                "currentPage":1,
                "totalNum":53,
                "totalPage":7
            }
      }],//二手物品列表
    }
  },
  methods: {
    search() {
      let categoryId,days;
      if(this.category === "类别")
        categoryId = 0;
      else
        categoryId = this.category;
      if(this.secTime === "发布时间")
        days = 0;
      else
        days = this.secTime;
      axios.post("/api/admin/listGoodsByKeyword",
          qs.stringify({
            days: days,
            categoryId: categoryId,
            keyWord: this.input,
            pageid: this.currentPage
          }),{
          headers:{
            'token': sessionStorage.getItem("token")
          }
          }
      ).then(res => {
        console.log(res.data);
        this.goodsList = res.data.data;
        this.currentPage = res.data.data[0].pageInfo.currentPage;
        this.totalNum = res.data.data[0].pageInfo.totalNum;
      })
    },//搜索

    viewDetail(index,row) {
      console.log(row.id);
      this.$router.push({name: "goodsDetail", params: {'id': row.id}})
    },//查看详情

    handleDelete(index,row) {
      let url = "/api/myGoods/withdrawGoodsById/" + row.id;
      axios.get(url,{
        headers:{
          'token': sessionStorage.getItem("token")
        }
      });
      console.log("删除" + row.id);
    },//删除

    handleCurrentChange(val) {
      this.currentPage = val;
      this.search();
    },//改变页面
  },
  beforeMount:function () {
    axios.get("/api/goods/listGoodsCategory",{
      headers:{
        'token': sessionStorage.getItem("token")
      }
    }).then(res => {
      console.log(res);
      this.categoryList = res.data.data;
    })
    this.search();
  },

}
</script>

<style>
  .searchInput {
    margin: 0 10%;
  }
  .searchSelect {
    margin: 0 10%;
  }
  .goodsTable {
    margin: 20px 10%;
  }
  .page {
    margin: 0 auto;
  }
</style>