--ACRM_F_AGREEMENT_LOAN_ACCT_INFO 客户贷款产品持有详情
alter table ACRM_F_AGREEMENT_LOAN_ACCT_INFO add (LOAN_NO VARCHAR2(50));
COMMENT ON COLUMN PCRM_APP.ACRM_F_AGREEMENT_LOAN_ACCT_INFO.LOAN_NO IS '借据编号';
alter table ACRM_F_AGREEMENT_LOAN_ACCT_INFO add (CURRENT_SHOULD_REPAY_PRINCIPLE NUMBER(24,4));
COMMENT ON COLUMN PCRM_APP.ACRM_F_AGREEMENT_LOAN_ACCT_INFO.CURRENT_SHOULD_REPAY_PRINCIPLE IS '本期应还本金';
alter table ACRM_F_AGREEMENT_LOAN_ACCT_INFO add (CURRENT_SHOULD_REPAY_INTEREST NUMBER(24,4));
COMMENT ON COLUMN PCRM_APP.ACRM_F_AGREEMENT_LOAN_ACCT_INFO.CURRENT_SHOULD_REPAY_INTEREST IS '本期应还利息';
alter table ACRM_F_AGREEMENT_LOAN_ACCT_INFO add (LOAN_DATE DATE);
COMMENT ON COLUMN PCRM_APP.ACRM_F_AGREEMENT_LOAN_ACCT_INFO.LOAN_DATE IS '放款日期';

--OCRM_F_WP_TODO_WORK 待办事项主表
alter table OCRM_F_WP_TODO_WORK add (CONTACT_TYPE VARCHAR2(10));
COMMENT ON COLUMN PCRM_APP.OCRM_F_WP_TODO_WORK.CONTACT_TYPE IS '接触类型';
alter table OCRM_F_WP_TODO_WORK add (CONTACT_GOAL VARCHAR2(10));
COMMENT ON COLUMN PCRM_APP.OCRM_F_WP_TODO_WORK.CONTACT_GOAL IS '接触目的';

--OCRM_F_WP_TODO_WORK_SON 待办事项子表
alter table OCRM_F_WP_TODO_WORK_SON add (CONTACT_TYPE VARCHAR2(10));
COMMENT ON COLUMN PCRM_APP.OCRM_F_WP_TODO_WORK_SON.CONTACT_TYPE IS '接触类型';
alter table OCRM_F_WP_TODO_WORK_SON add (CONTACT_GOAL VARCHAR2(10));
COMMENT ON COLUMN PCRM_APP.OCRM_F_WP_TODO_WORK_SON.CONTACT_GOAL IS '接触目的';

--OCRM_F_WP_CUSTOMER_CONTACT 客户接触
alter table OCRM_F_WP_CUSTOMER_CONTACT add (SOURCE_TABLE VARCHAR2(10));
COMMENT ON COLUMN PCRM_APP.OCRM_F_WP_CUSTOMER_CONTACT.SOURCE_TABLE IS '来源';

