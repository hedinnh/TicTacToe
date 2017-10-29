(function() {
    function updateCells(data) {
        let cells = $('.cell')
        for(let i = 0; i < data.cells.length; i++) {
            for(let j = 0; j < data.cells[i].length; j++) {
                let cellId = i * data.cells.length + j + 1
                if(data.cells[i][j] !== '-') {
                    $('#' + cellId).off('click').text(data.cells[i][j])                    
                } else {
                    $('#' + cellId).text('')                                        
                }
            }
        }
    }
    function cellClick(id) {
        console.log(id)
        $.post('updateCell', { id: id })
        .done(function(data) {
            console.log(data)
            updateCells(data)
        })
    }

    $('.cell').click(function (e) { cellClick(this.id); })


    $('.newGame').click(function(e) {
        console.log(e)
        $.post('reset')
        .done(function(data) {
            $('.cell').off('click').click(function (e) { cellClick(this.id); })
            console.log(data)
            updateCells(data)
        })
    })
})()
