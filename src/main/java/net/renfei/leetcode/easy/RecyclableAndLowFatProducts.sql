-- 1757. 可回收且低脂的产品
-- https://leetcode-cn.com/problems/recyclable-and-low-fat-products/
SELECT product_id
FROM Products
WHERE low_fats = 'Y'
  AND recyclable = 'Y'