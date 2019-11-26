```verilog
  FamilyMemberExample familyMemberExample = new FamilyMemberExample();
        familyMemberExample.createCriteria()
                .andIdIn(familyIdList)
                .andDelFlagEqualTo(BoHuiDataBase.isDelete_notDelete);

         familyMemberMapper.selectByExample(familyMemberExample);
```





http://localhost:8595/sv/SlowVisitReportDetailExcel/downExcelByFamilyMemberIdListDisease?chronicId=1&familyIdList=325,1847



```java

```

