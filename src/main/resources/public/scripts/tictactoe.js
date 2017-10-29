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
        if(data.winner[0] === 'O') {
            $("p").show();
            $("p").text("O Wins this round!")
        }
        if(data.winner[0] === 'X') {
            $("p").show();
            $("p").text("X Wins this round!")
        } 
        if(data.winner[0] === 'E') {
            $("p").show();
            $("p").text("Draw, please play again!")
        }
    }
    function cellClick(id) {
        console.log(id)
        $.post('updateCell', { id: id })
        .done(function(data) {
            updateCells(data)
        })
    }
    $('.cell').click(function (e) { cellClick(this.id); })
    $('.newGame').click(function(e) {
        $("p").hide();
        $.post('reset')
        .done(function(data) {
            $('.cell').off('click').click(function (e) { cellClick(this.id); })
            updateCells(data)
        })
    })
   
})()
