/*
	@modifier yachao
	@time 2017/02/09
	@description 在specialist_evaluation表中新增一个opinion字段
*/
ALTER TABLE specialist_evaluation ADD COLUMN opinion text AFTER reviewSuggestion;